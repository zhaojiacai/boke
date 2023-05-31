package com.dev.blog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//自定义异常类
@ResponseStatus(HttpStatus.NOT_FOUND) //指定一下状态
//HttpStatus.NOT_FOUND的意思就是将这个NotFoundException作为资源找不到的状态对应到404页面
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
