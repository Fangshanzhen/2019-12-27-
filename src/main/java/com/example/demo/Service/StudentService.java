package com.example.demo.Service;

import com.example.demo.Input.createInout;
import com.example.demo.Input.getmessageInout;
import com.example.demo.Output.createOutput;
import com.example.demo.Output.getMessageOutput;


/**
 * @author qianchen
 * @date 2019/12/26 11:51
 */
public interface StudentService {
    /**
     * 新增学生信息
     * @param request
     * @return
     */
    createOutput create(createInout request);

    /**
     * 根据学生id获得课程号及成绩
     * @param request
     * @return
     */
    getMessageOutput getMessage(getmessageInout request);
}
