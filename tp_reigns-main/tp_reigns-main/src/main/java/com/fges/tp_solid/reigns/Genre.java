/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

/**
 *
 * @author julie.jacques
 */
public enum Genre {
    ROI, REINE;
    
    public String longRegne(){
        if(this==ROI)
            return "Long règne au roi ";
        return "Long règne à la reine";
    }
}
