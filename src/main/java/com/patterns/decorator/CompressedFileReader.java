package com.patterns.decorator;

public class CompressedFileReader extends ReadDecorator {

    public CompressedFileReader(Reader reader) {
        super(reader);
    }

    public void read(){
        System.out.println("Decompresing file");
        this.reader.read();
    }
}
