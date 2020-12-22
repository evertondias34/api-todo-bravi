package com.apibravi.todo.resource.comentario;

import com.apibravi.todo.resource.tarefa.Tarefa;
import com.apibravi.todo.resource.tarefa.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comentarios")
public class ComentarioController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private ComentarioService comentarioService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Comentario salvar(@Valid @RequestBody Comentario novoComentario) throws Exception {
//        novaTarefa.setAtivo(true);
        return comentarioService.salvar(novoComentario
        );
    }
}
