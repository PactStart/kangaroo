package io.github.pactstart.simple.web.framework.encrypt.core;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {

    private byte[] requestBody = new byte[0];

    public EncryptRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            requestBody = IOUtils.toByteArray(request.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return bais.available() == 0;
            }

            @Override
            public boolean isReady() {
                return bais.available() == requestBody.length;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public long skip(long n) throws IOException {
                return bais.skip(n);
            }

            @Override
            public int available() throws IOException {
                return bais.available();
            }

            @Override
            public synchronized void mark(int readlimit) {
                bais.mark(readlimit);
            }

            @Override
            public synchronized void reset() throws IOException {
                bais.reset();
            }

            @Override
            public boolean markSupported() {
                return bais.markSupported();
            }
        };
    }

    public String getRequestData() {
        return new String(requestBody);
    }

    public void setRequestData(String requestData) {
        this.requestBody = requestData.getBytes();
    }
}
