package com.example.islapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The most of those information can be found in MNIST.ipynb 
 */
public class AlphaISLModelConfig {
    public static String MODEL_FILENAME = "model.tflite";

    public static final int INPUT_IMG_SIZE_WIDTH = 200;
    public static final int INPUT_IMG_SIZE_HEIGHT = 200;
    public static final int FLOAT_TYPE_SIZE = 4;
    public static final int PIXEL_SIZE = 1;
    public static final int MODEL_INPUT_SIZE = FLOAT_TYPE_SIZE * INPUT_IMG_SIZE_WIDTH * INPUT_IMG_SIZE_HEIGHT * PIXEL_SIZE*3;

    public static final List<Character> OUTPUT_LABELS = Collections.unmodifiableList(
            Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                    'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public static final int MAX_CLASSIFICATION_RESULTS = 3;
    public static final float CLASSIFICATION_THRESHOLD = 0.1f;
}
