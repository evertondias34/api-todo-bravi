package com.apibravi.todo.resource.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tarefas")
public class TarefaController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private TarefaService tarefaService;

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<Tarefa> findAll() {
        return tarefaService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("find")
    public Tarefa findById(@RequestParam Long id) {
        return tarefaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tarefa salvar(@Valid @RequestBody Tarefa novaTarefa) throws Exception {
        novaTarefa.setAtivo(true);
        return tarefaService.salvar(novaTarefa);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tarefa atualizar(@Valid @RequestBody Tarefa tarefaEditada) throws Exception {
        return tarefaService.update(tarefaEditada);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        tarefaService.deletar(id);
    }

}
