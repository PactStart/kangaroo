package io.github.pactstart.simple.web.framework.encrypt.core;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EncryptResponseWrapper extends HttpServletResponseWrapper {

    private ServletOutputStream filterOutput;

    private ByteArrayOutputStream output;

    public EncryptResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new ByteArrayOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (filterOutput == null) {
            filterOutput = new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    output.write(b);
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {
                }
            };
        }

        return filterOutput;
    }

    public String getResponseData() {
        return output.toString();
    }

}
