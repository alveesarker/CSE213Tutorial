package com.example.finalexam_yoursecno_yourid;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws Exception{
        super(out);
    }

    @Override
    protected void writeStreamHeader(){

    }
}
