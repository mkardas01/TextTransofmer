package pl.put.poznan.transformer.logic.transformers;

public class LowerDecorator implements TextTransformation {

    //returns text with lower cases
    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}