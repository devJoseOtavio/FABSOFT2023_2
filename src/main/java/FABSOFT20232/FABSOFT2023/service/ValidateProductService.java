package FABSOFT20232.FABSOFT2023.service;

import FABSOFT20232.FABSOFT2023.model.Product;

public class ValidateProductService {

    public Boolean validateSave(Product product) {
        Boolean validateSaveParams = true;
        float productValue;
        if (product.getName() == null || product.getProductType() == null) {
            return validateSaveParams = false;
        }

        // if (!product.getProductValue()) {
        //     return validateSaveParams = false;
        // }

        return true;
    }
    
}
