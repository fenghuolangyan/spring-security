package com.ft.security.security;

import com.ft.base.utils.MD5;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordEncoder implements PasswordEncoder {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public DefaultPasswordEncoder() {
        this(-1);
    }
    public DefaultPasswordEncoder(int strength) {
    }
    //进行MD5加密
    @Override
    public String encode(CharSequence charSequence) {
        return passwordEncoder.encode(charSequence.toString());
//        return MD5.encrypt(charSequence.toString());
    }
    //进行密码比对
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return passwordEncoder.matches(charSequence.toString(),encodedPassword);
//        return encodedPassword.equals(MD5.encrypt(charSequence.toString()));
    }
}
