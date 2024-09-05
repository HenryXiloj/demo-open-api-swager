package com.henry.openapi.controller;

import com.henry.openapi.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ItemsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.8.0")
public interface ItemsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /items : Create a new item
     *
     * @param item Item to create (required)
     * @return Item created successfully (status code 201)
     * @see ItemsApi#createItem
     */
    default ResponseEntity<Item> createItem(Item item) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /items/{id} : Delete an item by ID
     *
     * @param id  (required)
     * @return Item deleted successfully (status code 204)
     *         or Item not found (status code 404)
     * @see ItemsApi#deleteItemById
     */
    default ResponseEntity<Void> deleteItemById(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /items : Get all items
     *
     * @return Successful response (status code 200)
     * @see ItemsApi#getAllItems
     */
    default ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /items/{id} : Get an item by ID
     *
     * @param id  (required)
     * @return Successful response (status code 200)
     *         or Item not found (status code 404)
     * @see ItemsApi#getItemById
     */
    default ResponseEntity<Item> getItemById(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /items/{id} : Update an item by ID
     *
     * @param id  (required)
     * @param item Item to update (required)
     * @return Item updated successfully (status code 200)
     *         or Item not found (status code 404)
     * @see ItemsApi#updateItemById
     */
    default ResponseEntity<Item> updateItemById(Long id,
        Item item) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
