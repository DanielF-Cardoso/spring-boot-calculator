package br.com.daniel.springbootcalculator.controllers;

import br.com.daniel.springbootcalculator.converters.NumberController;
import br.com.daniel.springbootcalculator.exceptions.DivisionByZeroException;
import br.com.daniel.springbootcalculator.exceptions.InvalidNumberException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        Double sum = numberController.convertToDouble(numberOne) +  numberController.convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        Double subtraction = numberController.convertToDouble(numberOne) -  numberController.convertToDouble(numberTwo);
        return subtraction;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        Double multiplication = numberController.convertToDouble(numberOne) *  numberController.convertToDouble(numberTwo);
        return multiplication;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        if (numberController.convertToDouble(numberTwo) == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed", 400);
        }
        Double division = numberController.convertToDouble(numberOne) /  numberController.convertToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        Double mean = (numberController.convertToDouble(numberOne) +  numberController.convertToDouble(numberTwo)) / 2;
        return mean;
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(number)) {
            throw new InvalidNumberException("Letters are not allowed in calculator operations", 400);
        }
        Double squareRoot = Math.sqrt(numberController.convertToDouble(number));
        return squareRoot;
    }
}
