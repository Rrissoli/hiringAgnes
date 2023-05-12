package med.voll.api.services.Projetos;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Project;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadAllProjectsService {
    @Autowired
    private ProjectsRepository projetosRepository;

    public List<Project> execute(){
        List<Project> projetos = (List<Project>) projetosRepository.findAll();
        return projetos;
    }

}
