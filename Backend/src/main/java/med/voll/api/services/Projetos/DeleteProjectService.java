package med.voll.api.services.Projetos;

import lombok.RequiredArgsConstructor;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.repositories.ClientRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("projects")
public class DeleteProjectService {
    @Autowired
    private ProjectsRepository projectsRepository;
    public void delete(Long id) {
        Optional<Project> optionalProject = projectsRepository.findById(id);
        Project project = optionalProject.orElseThrow(() -> new RuntimeException("Não foi encontrado um cliente com o ID informado."));
        projectsRepository.delete(project);
    }
}
