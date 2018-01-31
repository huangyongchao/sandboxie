package app.controller;

import app.model.Sandboxie;
import app.repository.SandboxieRepository;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/")
public class SandboxieRestPost {

    @Autowired
    private SandboxieRepository sandboxieRepository;


    @RequestMapping(value="/{path}",method = RequestMethod.POST)
    public JSONObject getData(HttpServletRequest request) {


        return getJsonData(request);
    }

    @RequestMapping(value="/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData1(HttpServletRequest request) {

        return getJsonData(request);

    }
    @RequestMapping(value="/{path}/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData2(HttpServletRequest request) {

        return getJsonData(request);

    }
    @RequestMapping(value="/{path}/{path}/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData3(HttpServletRequest request) {

        return getJsonData(request);

    }
    @RequestMapping(value="/{path}/{path}/{path}/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData4(HttpServletRequest request) {

        return getJsonData(request);

    }
    @RequestMapping(value="/{path}/{path}/{path}/{path}/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData5(HttpServletRequest request) {

        return getJsonData(request);

    }
    @RequestMapping(value="/{path}/{path}/{path}/{path}/{path}/{path}/{path}",method = RequestMethod.POST)
    public JSONObject getData6(HttpServletRequest request) {


        return getJsonData(request);

    }

    private JSONObject getJsonData(HttpServletRequest request){
        Sandboxie sandboxie  = new Sandboxie();
        sandboxie.setPath(request.getAttribute("p").toString());
        sandboxie = sandboxieRepository.findOne(Example.of(sandboxie));
        if(sandboxie == null){
            return  new JSONObject();

        }
        JSONObject jsonObject = null;
        try {
            jsonObject =JSONObject.parseObject(sandboxie.getReturndata());
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = new JSONObject();
        }
        return  jsonObject;
    }

}
