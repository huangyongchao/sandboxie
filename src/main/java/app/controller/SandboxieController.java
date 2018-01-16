package app.controller;

import app.model.Sandboxie;
import app.repository.SandboxieRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/app")
public class SandboxieController {


    @Autowired
    private SandboxieRepository sandboxieRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String getBookDetails() {

        return "new";
    }




    @RequestMapping(method = RequestMethod.POST,value = "/save"  )
    public String createBook(@RequestParam Map data,ModelMap map) {
        Sandboxie sandboxie1 = new Sandboxie(data.get("path").toString(),data.get("returndata").toString());
        try {
            sandboxieRepository.save(sandboxie1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterable<Sandboxie> sandboxies = sandboxieRepository.findAll();
        List<Sandboxie> list = new LinkedList<>();
        sandboxies.forEach(sandboxie -> list.add(sandboxie));
        map.put("list",list);
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/" )
    public String getAll(@RequestParam(value = "path", required = false) String path,ModelMap map) {
        Iterable<Sandboxie> sandboxies = sandboxieRepository.findAll();
        List<Sandboxie> list = new LinkedList<>();
        sandboxies.forEach(sandboxie -> list.add(sandboxie));
        map.put("list",list);
        return "list";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id,ModelMap map) {
        try {
            sandboxieRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterable<Sandboxie> sandboxies = sandboxieRepository.findAll();
        List<Sandboxie> list = new LinkedList<>();
        sandboxies.forEach(sandboxie -> list.add(sandboxie));
        map.put("list",list);
        return "list";
    }

 /*
    @RequestMapping(method = RequestMethod.GET, value = "/{sandboxieId}")
    public JSONObject getBookDetails(@PathVariable("sandboxieId") String sandboxieId) {
        JSONObject j = new JSONObject();
        j.put("id",1);
        return j;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{sandboxieId}")
    public Map<String, Object> editBook(@PathVariable("sandboxieId") String sandboxieId,
                                        @RequestBody Map<String, Object> sandboxieMap) {
        Sandboxie sandboxie = new Sandboxie(sandboxieMap.get("name").toString(),
                sandboxieMap.get("isbn").toString(),
                sandboxieMap.get("author").toString(),
                Integer.parseInt(sandboxieMap.get("pages").toString()));
        sandboxie.setId(sandboxieId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book Updated successfully");
        response.put("sandboxie", sandboxieRepository.save(sandboxie));
        return response;
    }




*/
}
