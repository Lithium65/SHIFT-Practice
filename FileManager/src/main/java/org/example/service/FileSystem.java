package org.example.service;

import java.io.File;

public interface FileSystem {
    void read (File file);
    void create (File file);
    void delete (File file);
    void update (File file);
}
