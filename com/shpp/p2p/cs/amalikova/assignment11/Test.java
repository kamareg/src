package com.shpp.p2p.cs.amalikova.assignment11;

public class Test {
    public static void main(String[] args) {
        Assignment11Part1.main(new String[]{});                                          //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"  "});                                     //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"2jhv"});                                   //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"123", "   fjf  "});                        //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"a+2"});                                    //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"-1.38*-3a", "a=-2.46"});                   //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"-1.38**a", "a=-2.46"});                    //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"1+a*2"});                                  //There are some problems with your expression.
        Assignment11Part1.main(new String[]{"123"});                                    //123
        Assignment11Part1.main(new String[]{"a+2", " a = 7091   "});                    //7093.0
        Assignment11Part1.main(new String[]{" a  +  2 ", "   a = 7091  "});             //7093.0
        Assignment11Part1.main(new String[]{"1.0+2.9", "a=1"});                         //3.9
        Assignment11Part1.main(new String[]{"a+2.9", "a=  -11.48  "});                  //-8.58
        Assignment11Part1.main(new String[]{"a+2,9", "a=1", "b=2"});                    //3.9
        Assignment11Part1.main(new String[]{"1 +  a *  2.5", "a = -2", "b=0.8", "c=  99"});             //-4.0
        Assignment11Part1.main(new String[]{"1 + a*  2,5", "a = -4"});                                  //-9.0
        Assignment11Part1.main(new String[]{"1+a*2.5", "a = -20"});                                     //-49.0
        Assignment11Part1.main(new String[]{"1+a*2.5", "a = -2"});                                      //-4.0
        Assignment11Part1.main(new String[]{"-2.0 ^  a", "a =-3.0"});                                   //-0.125
        Assignment11Part1.main(new String[]{"a + 3.0 + b", "a=3.0", "b = 2"});          //8.0
        Assignment11Part1.main(new String[]{"1+3*2"});                                  //7.0
        Assignment11Part1.main(new String[]{"1.0+a*2.5/a", "a=2"});                     //3.5
        Assignment11Part1.main(new String[]{"2^3^2"});                                  //64.0
        Assignment11Part1.main(new String[]{"2+3-4+8-10"});                             //-1
        Assignment11Part1.main(new String[]{"1+3-4*2/3+7^8-4"});                        //5764798.333333333
        Assignment11Part1.main(new String[]{"1+2*3/4*2^2^2/5-4-2-3*2"});                //-6.2
        Assignment11Part1.main(new String[]{"2*3-4/8-10+9-1*4/8"});                     //4
        Assignment11Part1.main(new String[]{"-0.1*10+1", "a=10.1", "b = 2"});           //0
        Assignment11Part1.main(new String[]{"a-b", "a=-1", "b=-1"});                    //0
        Assignment11Part1.main(new String[]{"-a-b", "a=7.6", "b=-1.8"});                //-5.8
        Assignment11Part1.main(new String[]{"-a-b^9", "a=-1.98", "b=1.38"});            //-16.17
        Assignment11Part1.main(new String[]{"ax-b^10.48", "ax=7.5", "b=10"});           //-3.019951719652019E10
        Assignment11Part1.main(new String[]{"-c-10.38", "c=-8"});                       //-2.38
        Assignment11Part1.main(new String[]{"a-b*3^a", "a=-8.41", "b=1"});              //-8.41
        Assignment11Part1.main(new String[]{"1.45/a^b*4", "a=8.41", "b=1.38"});         //0.3
        Assignment11Part1.main(new String[]{"c+1.45/a^b-4^b^b-c+48^a*c/8+c", "a=8.41", "b=1.38", "c= -  1.0016"});         //-1.7252146413257389E13
        Assignment11Part1.main(new String[]{"-(2+2)"});                                 //-4.0
        Assignment11Part1.main(new String[]{"-((2+2)^(2*2))+(300-50+6)"});              //0
        Assignment11Part1.main(new String[]{"(6+10-4)/(1+1*2)+1"});                     //5.0
        Assignment11Part1.main(new String[]{"1+(2+3*(4+5-sin(45*cos(a))))/7"});         //5.0

        //"c+ b * 2 -1 + a  * xs+ 2+1"  "a = 2"  b=3 "c =1"  "xs=10"
        // 123              123
        // a+2 "a=3.8"        5.8
        // "a+2" a=3.8        5.8
        // a  +2 a  =5      Exception
    }
}
//D:\Sh++\11\src>javac com\shpp\p2p\cs\amalikova\assignment11\Assignment11Part1.java
//D:\Sh++\11\src>java com.shpp.p2p.cs.amalikova.assignment11.Assignment11Part1