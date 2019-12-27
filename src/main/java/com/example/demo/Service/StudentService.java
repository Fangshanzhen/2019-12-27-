package com.example.demo.Service;

import com.example.demo.Input.createInout;
import com.example.demo.Input.getmessageInout;
import com.example.demo.Output.createOutput;
import com.example.demo.Output.getmessageOutput;

/**
 * @author qianchen
 * @date 2019/12/26 11:51
 */
public interface StudentService {
    createOutput create(createInout request);

    getmessageOutput getmessage(getmessageInout request);
}
