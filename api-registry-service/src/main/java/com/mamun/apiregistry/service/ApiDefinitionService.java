package com.mamun.apiregistry.service;


import com.mamun.apiregistry.dto.CreateApiRequest;
import com.mamun.apiregistry.model.ApiDefinition;
import com.mamun.apiregistry.repository.ApiDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiDefinitionService {

    private final ApiDefinitionRepository apiRepository;
    //private final UserRepository userRepository;
    public ApiDefinition createApi(CreateApiRequest request) {

        ApiDefinition api = ApiDefinition.builder()
                .name(request.getName())
                .description(request.getDescription())
                .baseUrl(request.getBaseUrl())
                .category(request.getCategory())
                .active(true)
                .createdAt(LocalDateTime.now())
                .ownerId(request.getOwnerId())
                .build();

        return apiRepository.save(api);
    }

    public List<ApiDefinition> getAllApis() {
        return apiRepository.findAll();
    }

    public ApiDefinition getApi(Long id) {
        return apiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("API not found"));
    }
}