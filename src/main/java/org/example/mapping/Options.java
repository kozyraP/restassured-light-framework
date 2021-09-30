package org.example.mapping;


public class Options {
    private boolean advertisement;
    private boolean advertisementPriceOptional;
    private boolean variantsByColorPatternAllowed;
    private boolean offersWithProductPublicationEnabled;
    private boolean productCreationEnabled;
    private boolean customParametersEnabled;
    private boolean variantsAllowed;
    private boolean variantsEqual;
    private String ambiguousValueId;
    private String dependsOnParameterId;
    private String[] requiredDependsOnValueIds;
    private String[] displayDependsOnValueIds;
    private boolean describesProduct;
    private boolean customValuesEnabled;

    public boolean isAdvertisement() {
        return advertisement;
    }

    public boolean isAdvertisementPriceOptional() {
        return advertisementPriceOptional;
    }

    public boolean isVariantsByColorPatternAllowed() {
        return variantsByColorPatternAllowed;
    }

    public boolean isOffersWithProductPublicationEnabled() {
        return offersWithProductPublicationEnabled;
    }

    public boolean isProductCreationEnabled() {
        return productCreationEnabled;
    }

    public boolean isCustomParametersEnabled() {
        return customParametersEnabled;
    }

    public boolean isVariantsAllowed() {
        return variantsAllowed;
    }

    public boolean isVariantsEqual() {
        return variantsEqual;
    }

    public String getAmbiguousValueId() {
        return ambiguousValueId;
    }

    public String getDependsOnParameterId() {
        return dependsOnParameterId;
    }

    public String[] getRequiredDependsOnValueIds() {
        return requiredDependsOnValueIds;
    }

    public String[] getDisplayDependsOnValueIds() {
        return displayDependsOnValueIds;
    }

    public boolean isDescribesProduct() {
        return describesProduct;
    }

    public boolean isCustomValuesEnabled() {
        return customValuesEnabled;
    }
}
