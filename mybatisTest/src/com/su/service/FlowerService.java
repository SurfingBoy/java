package com.su.service;

import java.io.IOException;
import java.util.List;

import com.su.model.Flower;

public interface FlowerService {
	List<Flower> show() throws IOException;
}
