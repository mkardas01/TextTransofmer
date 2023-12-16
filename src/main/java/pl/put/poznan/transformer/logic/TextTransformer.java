package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.decorators.*;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextTransformer implements TextTransformation {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformation.class);
    public final String transforms;
    private final TextTransformation[] transformers;

    public TextTransformer(String[] transforms) {
        this.transforms = Arrays.toString(transforms);
        this.transformers = initializeTransformers(transforms);

    }

    //initialize TextTransformation depends on transforms
    private TextTransformation[] initializeTransformers(String[] transforms) {
        logger.info("Initialize transformers");
        TextTransformation[] transformers = new TextTransformation[transforms.length];
                for (int i = 0; i < transforms.length; i++) {
                    switch (transforms[i]) {
                        case "upper":
                            transformers[i] = new UpperDecorator ();
                            break;
                        case "lower":
                            transformers[i] = new LowerDecorator ();
                            break;
                        case "capitalize":
                            transformers[i] = new CapitalizeDecorator ();
                            break;
                        case "inverse":
                            transformers[i] = new InverterDecotaror ();
                            break;
                        case "short":
                            transformers[i] = new ShortCutterDecorator ();
                            break;
                        case "extend":
                            transformers[i] = new ShortExtenderDecorator ();
                            break;
                        case "number":
                            transformers[i] = new NumbererDecorator ();
                            break;
                        case "repetition":
                            transformers[i] = new EliminateRepetitionDecorator ();
                            break;
                    }
                    logger.debug("Added {}", transformers[i]);
                }

        return transformers;
    }

    //every TextTransformations transforms text
    @Override
    public String transform(String text) {
        for (TextTransformation transformer : transformers) {
            text = transformer.transform(text);
            logger.debug("text: {} after: {}", text, transformer);
        }
        logger.info("text after all transforms: {}", text);
        //returns text after all transformations
        return text;
    }
}