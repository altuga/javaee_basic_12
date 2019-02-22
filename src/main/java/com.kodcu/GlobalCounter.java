package com.kodcu;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class GlobalCounter extends Counter implements Serializable {
}
