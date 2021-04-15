package eci.ieti.controller;


import com.mongodb.client.gridfs.model.GridFSFile;
import eci.ieti.data.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.management.Query;
import java.io.IOException;
import java.util.List;

@RequestMapping("api")
@RestController
public class RESTController {

    @Autowired
    GridFsTemplate gridFsTemplate = null;

   //TODO inject components (TodoRepository and GridFsTemplate)

    @RequestMapping("/files/{filename}")
    public ResponseEntity<InputStreamResource> getFileByName(@PathVariable String filename) throws IOException {

        //TODO implement method
        return null;

    }

    @CrossOrigin("*")
    @PostMapping("/files")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        //TODO implement method
        try{
            GridFSFile filen = gridFsTemplate.findOne(new Query().addCriteria(Criteria.where("filename").is(file)));
            GridFsResource resource = gridFsTemplate.getResource(filen.getFilename());
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(resource.getContentType()))
                    .body(new InputStreamResource(resource.getInputStream()));
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @CrossOrigin("*")
    @PostMapping("/todo")
    public Todo createTodo(@RequestBody Todo todo) {
        //TODO implement method
        return null;
    }

    @CrossOrigin("*")
    @GetMapping("/todo")
    public List<Todo> getTodoList() {
        //TODO implement method
        return null;
    }

}
