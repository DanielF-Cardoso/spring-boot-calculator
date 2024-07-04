package br.com.daniel.springbootcalculator.controllers;

import br.com.daniel.springbootcalculator.converters.NumberController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        NumberController numberController = new NumberController();
        if (!numberController.isNumeric(numberOne) || !numberController.isNumeric(numberTwo)) {
            throw new Exception();
        }
        Double sum = numberController.convertToDouble(numberOne) +  numberController.convertToDouble(numberTwo);
        return sum;
    }
}
