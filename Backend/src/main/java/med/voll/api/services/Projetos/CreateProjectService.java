package med.voll.api.services.Projetos;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import med.voll.api.dtos.ProjectDTOS.CreateProjectDTO;
import med.voll.api.models.Client;
import med.voll.api.models.Project;
import med.voll.api.repositories.ClientRepository;
import med.voll.api.repositories.LabelsRepository;
import med.voll.api.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("projects")
public class CreateProjectService {
    @Autowired
    private  ProjectsRepository projectRepository;
    @Autowired
    private  LabelsRepository labelRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Getter
    @Setter
    private List<String> defaultColors;

    @Transactional
    public Project execute(CreateProjectDTO createProject){
        Optional<Client> optionalClient = clientRepository.findById(createProject.getClient_id());
        Client client = optionalClient.orElseThrow(() -> new RuntimeException("Não foi encontrado um cliente com o ID informado."));

        Project project = new Project(createProject , client);
        Project saved = projectRepository.save(project);

        return saved;
    }



}
