package med.voll.api.services.Projetos;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.repositories.ClientRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadOnlyProjectsService {
    @Autowired
    private ProjectsRepository projectRepository;

    public Project execute(Long id){
        Optional<Project> optionalProject = projectRepository.findById(id);
        Project project = optionalProject.orElseThrow(() -> new RuntimeException("Não foi encontrado um projeto com o ID informado."));
        return project;
    }
}
