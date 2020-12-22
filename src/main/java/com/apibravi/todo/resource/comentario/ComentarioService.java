package com.apibravi.todo.resource.comentario;

import com.apibravi.todo.resource.tarefa.Tarefa;
import com.apibravi.todo.resource.tarefa.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TarefaService tarefaService;

    public Comentario salvar(Comentario comentarioNovo) {

        Tarefa tarefaOrigem =tarefaService.findById(comentarioNovo.getIdTarefa());
        comentarioNovo.setTarefa(tarefaOrigem);

//        LOG.info(comentarioNovo.getDescricao() + " idTarefa " + comentarioNovo.getTarefa().getId());

        Comentario comentarioSalvo = comentarioRepository.save(comentarioNovo);

        LOG.info(comentarioSalvo.getId() + "idSalvo");

        return comentarioSalvo;
    }
}
