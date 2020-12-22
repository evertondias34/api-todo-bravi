package com.apibravi.todo.resource.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
public class TarefaService {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> findAll() {

        List<Tarefa> result = tarefaRepository.findAll();

        for (Tarefa tarefa : result) {
            setDataFormatada(tarefa);

            if (tarefa.getIsAtivo()) {
                setStatus(tarefa);
            }
        }

        return result;
    }

    private void setDataFormatada(Tarefa tarefa) {
        Date date = tarefa.getDataPrevista();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        String dateFormatada = dateFormat.format(date);

        tarefa.setData(dateFormatada);
    }

    private void setStatus(Tarefa tarefa) {
        Date hoje = new Date();

        LocalDate dataCurrent = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(hoje));
        LocalDate dataPrevista = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(tarefa.getDataPrevista()));

        if (dataPrevista.isAfter(dataCurrent)) {
            tarefa.setIsAgendada(true);

        } else if (dataPrevista.isBefore(dataCurrent)) {
            tarefa.setIsAtrasada(true);
        } else {
            tarefa.setIsPraHoje(true);
        }
    }

    public Tarefa findById(Long id) {
        return tarefaRepository.findById(id).get();
    }

    public Tarefa salvar(Tarefa tarefaNova) {
        return tarefaRepository.save(tarefaNova);
    }

    public Tarefa update(Tarefa tarefaEditada) {
        System.out.println(tarefaEditada.getDataPrevista());
        return tarefaRepository.save(tarefaEditada);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

}
