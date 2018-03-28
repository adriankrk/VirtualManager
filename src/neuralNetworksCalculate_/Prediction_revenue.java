/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNetworksCalculate_;

import main_package.model.Revenues_struct_yaml;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingElement;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.learning.LMS;

/**
 *
 * @author Adrian
 */
public class Prediction_revenue {
    private final List<Float> revenues;

    public Prediction_revenue(List<Revenues_struct_yaml> revenues_original) {
        this.revenues = new ArrayList<>();
        revenues_original.forEach((revenue) -> {
            revenues.add(revenue.getRevenue());
        });
    }
    
    @SuppressWarnings("empty-statement")
    public double predictRevenue(){
        NeuralNetwork neuralNet = new MultiLayerPerceptron(11,2,1);
        ((LMS) neuralNet.getLearningRule()).setMaxError(0.001);//0-1
        ((LMS) neuralNet.getLearningRule()).setLearningRate(0.7);//0-1
        ((LMS) neuralNet.getLearningRule()).setMaxIterations(10000);//0-1
        TrainingSet trainingSet = new TrainingSet();
        double revmax = 10000.0D;
        double[] input = new double[11];
        double[] desiredOutput = new double[1];
        
        for (int i=1; i<12; i++){
            input[i-1] = revenues.get(i);
        }        
        desiredOutput[0] = revenues.get(12);
        trainingSet.addElement(new SupervisedTrainingElement(input, desiredOutput));
        
        for (int i=13; i<24; i++){
            input[i-13] = revenues.get(i);
        }
        desiredOutput[0] = revenues.get(24);
        trainingSet.addElement(new SupervisedTrainingElement(input, desiredOutput));
        
        for (int i=25; i<36; i++){
            input[i-25] = revenues.get(i);
        }
        desiredOutput[0] = revenues.get(36);
        trainingSet.addElement(new SupervisedTrainingElement(input, desiredOutput));
        
        neuralNet.learnInSameThread(trainingSet);
        TrainingSet testSet = new TrainingSet();
        
        for (int i=37; i<48; i++){
            input[i-37] = revenues.get(i);
        }
        testSet.addElement(new TrainingElement(input));
        
        double Output = 0.0;
        for (TrainingElement testElement : testSet.trainingElements()) {
            neuralNet.setInput(testElement.getInput());
            neuralNet.calculate();
            Vector<Double> networkOutput = neuralNet.getOutput();
            System.out.print("Input: " + testElement.getInput());
            System.out.println(" Output: " + networkOutput);
            Output=networkOutput.get(0);
        }
        return Output;
    }
    
    
}
