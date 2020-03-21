package com.lesson.boot.jdbc.support.lock;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhengshijun
 * @version created on 2019/8/24.
 */
class LuaScriptRepository {

    final static String UNLOCK_LUA_SCRIPT = getUnlockLuaScript();

    private static String getUnlockLuaScript(){
        return "if redis.call(\"get\",KEYS[1]) == ARGV[1] then" +
                StringUtils.LF +
                StringUtils.repeat(StringUtils.SPACE, 2) + "return redis.call(\"del\",KEYS[1])" +
                StringUtils.LF +
                "else" +
                StringUtils.LF +
                StringUtils.repeat(StringUtils.SPACE, 2) + "return 0" +
                StringUtils.LF +
                "end";

    }

}

