package pl.put.poznan.transformer.logic;

/**
 * This interface defines the contract for text transformation decorators.
 *
 * Parameters:
 * @param  text (String) - Text provided by the user.
 * 
 * Returns:
 * @return  transformedText (String) - Transformed input.
 */

//interface for text transformations
public interface TextTransformation {
    String transform(String text);
}