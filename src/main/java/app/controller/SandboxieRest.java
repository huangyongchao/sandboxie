package app.controller;

import app.model.Sandboxie;
import app.repository.SandboxieRepository;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class SandboxieRest {

    @Autowired
    private SandboxieRepository sandboxieRepository;


    @RequestMapping(value="/**",method = RequestMethod.GET )
    public JSONObject getData(HttpServletRequest request ) {

        return getJsonData(request);
    }

    @RequestMapping(value="/**",method = RequestMethod.POST)
    public JSONObject getData1(HttpServletRequest request ) {

        return getJsonData(request);

    }


    private JSONObject getJsonData(HttpServletRequest request ){
        Sandboxie sandboxie  = new Sandboxie();
        String method = request.getHeader("appmethod");
        if(StringUtils.isEmpty(method)){
            method = request.getHeader("method");
        }
        if(StringUtils.isEmpty(method)){

            sandboxie.setPath(request.getAttribute("p").toString());
        }else{
            sandboxie.setPath(method);

        }
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
