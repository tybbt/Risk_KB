package com.tybbt.risk_kb.controller;

import com.alibaba.fastjson.JSONObject;
import com.tybbt.risk_kb.req.UserLoginReq;
import com.tybbt.risk_kb.req.UserQueryReq;
import com.tybbt.risk_kb.req.UserResetPasswordReq;
import com.tybbt.risk_kb.req.UserSaveReq;
import com.tybbt.risk_kb.resp.CommonResp;
import com.tybbt.risk_kb.resp.PageResp;
import com.tybbt.risk_kb.resp.UserLoginResp;
import com.tybbt.risk_kb.resp.UserQueryResp;
import com.tybbt.risk_kb.service.UserService;
import com.tybbt.risk_kb.util.RedisUtil;
import com.tybbt.risk_kb.util.SnowFlake;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

// @RestController 用于返回一个字符串，一般是Json对象 | @Controller用于返回一个页面
// 在外层类增加@RequestMapping注解，可以直接作为公共的上层链接，后续内部无论使用GET POST都可以作为请求的前缀
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    // 用于加载application自定义配置项，使用 custom.args:Default 作为默认配置防止转移环境时忘记配置
    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SnowFlake snowFlake;

    // 程序接口入口 -> 调用userService 的list方法
    @GetMapping ("/list")
    public CommonResp<PageResp<UserQueryResp>> list(@Valid UserQueryReq req){
        // 前后端参数名称需一致，才能自动映射。
        CommonResp<PageResp<UserQueryResp>> response = new CommonResp<>();
        PageResp<UserQueryResp> list = userService.list(req);
        response.setContent(list);
        return response;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req){
        // 前端如果使用POST提交中Content-Type为application/json方式，则需要RequestBody注解包裹request才能处理，axios使用json
        // 如果利用application/x-www-form的方式提交则不需要加注解
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }

    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req){
        // 前端如果使用POST提交中Content-Type为application/json方式，则需要RequestBody注解包裹request才能处理，axios使用json
        // 如果利用application/x-www-form的方式提交则不需要加注解
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.resetPassword(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        // delete 一般根据id删除，所以需要在接口中明确需要删除的id，这个id通过PathVariable映射给id参数
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }

    @PostMapping("/login")
    public CommonResp<UserLoginResp> login(@Valid @RequestBody UserLoginReq req){
        // 前端如果使用POST提交中Content-Type为application/json方式，则需要RequestBody注解包裹request才能处理，axios使用json
        // 如果利用application/x-www-form的方式提交则不需要加注解
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp = userService.login(req);

        // 生成单点登录token，放入redis
        Long token = snowFlake.nextId();
        LOG.info("生成单点登录token: {}，放入redis, 值为 {}", token.toString(), JSONObject.toJSONString(userLoginResp));
        userLoginResp.setToken(token.toString());
        redisUtil.writeUser(token.toString(), JSONObject.toJSONString(userLoginResp));
        RedisUtil.redis.opsForValue().set(token.toString(), JSONObject.toJSONString(userLoginResp), 3600*24, TimeUnit.SECONDS);
        Object object = RedisUtil.redis.keys("*");
        LOG.info("GET Redis All keys: {}", object);
        resp.setContent(userLoginResp);
        return resp;
    }

    @GetMapping("/login/all")
    public Object all() {
        Object object = RedisUtil.redis.keys("*");
        LOG.info("GET Redis All keys: {}", object);
        return object;
    }

    @GetMapping("/logout/{token}")
    private CommonResp logout(@PathVariable String token) {
        CommonResp resp = new CommonResp<>();
        LOG.info("从redis中删除token {}", token);
        boolean res = false;
        if (Boolean.TRUE.equals(RedisUtil.redis.hasKey(token))) {
            LOG.info("key已存在：{}", token);
            res = Boolean.TRUE.equals(RedisUtil.redis.delete(token));
        } else {
            LOG.info("key不存在");
        }

        resp.setSuccess(res);
        if (res) {
           resp.setMessage("退出成功");
        } else {
            resp.setMessage("退出失败");
        }
        return resp;
    }
}
