package com.example.demo.test.ehcache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description ehcache自动义缓存key的生成策略
 * @Date 2020/3/9 15:01
 * @Author cly
 **/
//@Configuration
public class CustomKeyGenerator implements KeyGenerator , Serializable {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return new CustomKey(target.getClass(), method.getName(), params);
    }
    static final class CustomKey implements Serializable{

        private final Class<?> clazz;
        private final String methodName;
        private final Object[] params;
        private final int hashCode;

        /**
         * Initialize a key.
         *
         * @param clazz the receiver class
         * @param methodName the method name
         * @param params the method parameters
         */
        CustomKey(Class<?> clazz, String methodName, Object[] params) {
            this.clazz = clazz;
            this.methodName = methodName;
            this.params = params;
            int code = Arrays.deepHashCode(params);
            code = 31 * code + clazz.hashCode();
            code = 31 * code + methodName.hashCode();
            this.hashCode = code;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomKey)) {
                return false;
            }
            CustomKey other = (CustomKey) obj;
            if (this.hashCode != other.hashCode) {
                return false;
            }

            return this.clazz.equals(other.clazz)
                    && this.methodName.equals(other.methodName)
                    && Arrays.deepEquals(this.params, other.params);
        }

    }
}
