package FABSOFT20232.FABSOFT2023.service;

import FABSOFT20232.FABSOFT2023.model.Product;

public class ValidateProductService {

    public Boolean validateSave(Product product) {
        boolean validateSaveParams = true;
        float productValue;
        if (product.getName() == null || product.getProductType() == null) {
            return validateSaveParams = false;
        }

        if (productValue.isEmpty(product.getProductValue())) {
            return validateSaveParams = false;
        }

        return true;
    }
    
}
