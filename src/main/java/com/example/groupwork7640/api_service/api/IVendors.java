package com.example.groupwork7640.api_service.api;

import com.example.groupwork7640.api_service.dto.VendorsDto;
import com.example.groupwork7640.crud.Vendors;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vendors/")
public class IVendors {

    @Resource
    Vendors vendors;

    @RequestMapping(value = "/queryAll")
    public ResponseEntity<List<VendorsDto>> queryAll() {
        return ResponseEntity.ok(vendors.queryAll());
    }

    @RequestMapping(value = "/create")
    public ResponseEntity<String> create(@RequestBody VendorsDto vendorsDto) {
        return ResponseEntity.ok(vendors.create(vendorsDto));
    }
}
