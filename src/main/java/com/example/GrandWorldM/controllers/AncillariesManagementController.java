package com.example.GrandWorldM.controllers;

import com.example.GrandWorldMSpec.generated.controller.interfaces.AncillariesManagementApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AncillariesManagementController implements AncillariesManagementApi {

    @Override
    public ResponseEntity<String> getAncillaries(@Valid String ancillarieName) {
        return null;
    }

}
