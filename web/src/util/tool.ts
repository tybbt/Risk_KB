export class Tool {

    /**
     * 空校验 null或""都返回true
     */
    public static isEmpty (obj: any) {
        if ((typeof obj === 'string')) {
            return !obj || obj.replace(/\s+/g, "") === "";
        } else {
            return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0);
        }
    }

    /**
     * 非空校验
     */
    public static isNotEmpty (obj: any) {
        return !this.isEmpty(obj);
    }

    /**
     * 对象复制
     * @param obj
     */
    public static copy (obj: any) {
        if (Tool.isNotEmpty(obj)) {
            return JSON.parse(JSON.stringify(obj));
        }
    }

    public static baseKnowledgeTransform(obj: any, keys: any) {
        if (Tool.isEmpty(obj)) {
            return false
        } else {
            const items = [];
            for (let i = 0; i < obj.length ; i++) {
                if (obj[i].state != 1) {
                    continue
                }
                const result: any = {
                    'id': obj[i].id,
                    'kid': obj[i].kid,
                    'state': obj[i].state
                }
                const values = JSON.parse(obj[i].values);
                console.log("values: ", values)
                console.log("keys", keys)
                if (values.length === keys.length) {
                    for (let j = 0; j < values.length ; j++) {
                        result[keys[j]] = values[j]
                    }
                } else {
                    continue
                }
                items.push(result);
            }
            return items;
        }
    }

    public static reverseKnowledge (obj: any) {
        if (Tool.isEmpty(obj)){
            return false;
        } else {
            const result = {
                'id': obj.id,
                'name': obj.name,
                'category': obj.category,
                'manager': obj.managers[0],
                'activateTime': obj.activateTime,
                'expireTime': obj.expireTime,
                'reviewer1': obj.managers.length > 1 ? obj.managers[1] : null,
                'reviewer2': obj.managers.length > 2 ? obj.managers[2] : null,
                'reviewer3': obj.managers.length > 3 ? obj.managers[3] : null,
                'state': obj.state,
                'number': obj.number
            }
            return result
        }
    }

    public static copyKnowledges (obj: any) {
        if (Tool.isEmpty(obj)) {
            return []
        } else {
            const knowledges = [];
            for (let i = 0; i < obj.length; i++) {
                const result = {
                    'id': '',
                    'name': '',
                    'state': 0,
                    'category': '',
                    'managers': [''],
                    'activateTime': '',
                    'expireTime': '',
                    'number': 0
                }
                const c = obj[i];
                result.id = c.id;
                result.name = c.name;
                result.state = c.state;
                result.category = c.category;
                result.activateTime = c.activateTime;
                result.expireTime = c.expireTime;
                result.number = c.number;
                result.managers.push(c.manager);
                result.managers.push(c.reviewer1);
                result.managers.push(c.reviewer2);
                result.managers.push(c.reviewer3);
                result.managers = result.managers.filter(function (s){
                    return s && s.trim();
                });
                if (result.managers.length == 0) {
                    result.managers = ['无']
                }
                knowledges.push(result);
            }
            return knowledges;
        }
    }

    /**
     * 使用递归将数组转为树形结构
     * 父ID属性为parent
     */
    public static array2Tree (array: any, parentId: number) {
        if (Tool.isEmpty(array)) {
            // console.log("array is null")
            return [];
        }
        // console.log("start reverse ", array.length)
        const result = [];
        for (let i = 0; i < array.length; i++) {
            const c = array[i];
            // console.log(c)
            // console.log(Number(c.parent), Number(parentId));
            if (Number(c.parent) === Number(parentId)) {
                result.push(c);

                // 递归查看当前节点对应的子节点
                const children = Tool.array2Tree(array, c.id);
                if (Tool.isNotEmpty(children)) {
                    c.children = children;
                }
            }
        }
        return result;
    }

    /**
     * 随机生成[len]长度的[radix]进制数
     * @param len
     * @param radix 默认62
     * @returns {string}
     */
    public static uuid (len: number, radix = 62) {
        const chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        const uuid = [];
        radix = radix || chars.length;

        for (let i = 0; i < len; i++) {
            uuid[i] = chars[0 | Math.random() * radix];
        }

        return uuid.join('');
    }
}
