package io.github.pactstart.simple.web.framework.wrapper;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ServletInputStreamWrapper extends ServletInputStream {

    private ByteArrayInputStream bais;

    private int size;

    public ServletInputStreamWrapper(ServletInputStream servletInputStream) throws IOException {
        byte[] body = IOUtils.toByteArray(servletInputStream);
        this.bais = new ByteArrayInputStream(body);
        this.size = body.length;
    }

    @Override
    public boolean isFinished() {
        return bais.available() == 0;
    }

    @Override
    public boolean isReady() {
        return bais.available() == this.size;
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
}
