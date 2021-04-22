package com.lysachenko.controller;

import com.lysachenko.model.Notebook;
import com.lysachenko.service.NotebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
@RequiredArgsConstructor
public class NotebookController {

    private final NotebookService notebookService;

    @GetMapping
    public ResponseEntity<List<Notebook>> getAll() {
        return ResponseEntity.ok(notebookService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Notebook> getById(@PathVariable Long id) {
        return ResponseEntity.ok(notebookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook) {
        notebookService.save(notebook);
        return ResponseEntity.ok(notebook);
    }

    @PutMapping
    public ResponseEntity<Notebook> updateNotebook(@RequestBody Notebook notebook) {
        notebookService.update(notebook);
        return ResponseEntity.ok(notebook);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Notebook> deleteNotebook(@PathVariable Long id) {
        Notebook notebook = notebookService.getById(id);
        notebookService.delete(notebook);
        return ResponseEntity.ok(notebook);
    }

    @GetMapping("ordered-by-manufacturer")
    public ResponseEntity<List<Notebook>> getAllOrderByManufacturer() {
        return ResponseEntity.ok(notebookService.getAllOrderByManufacturer());
    }

    @GetMapping("memory")
    public ResponseEntity<List<Notebook>> getNotebooksThereMemoryMore(@RequestParam("value") int value) {
        return ResponseEntity.ok(notebookService.getNotebooksByMemoryAfter(value));
    }

    @GetMapping("was-in-use")
    public ResponseEntity<List<Notebook>> getNotebooksWasInUse() {
        return ResponseEntity.ok(notebookService.getNotebooksByWasInUse());
    }
}
