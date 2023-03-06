package com.ojieabujoel.service;

import com.ojieabujoel.helper.ExcelHelper;
import com.ojieabujoel.model.Branch;
import com.ojieabujoel.repository.BranchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    BranchRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Branch> branches = ExcelHelper.excelToBranches(file.getInputStream());

            repository.saveAll(branches);

        } catch (IOException e) {

            throw new RuntimeException("fail to store excel data:" + e.getMessage());
        }
    }

    public List<Branch> getAllBranches() {
        return repository.findAll();
    }

}
