package com.fxp.libzxing.camera;

public interface PreviewFrameShotListener {
	public void onPreviewFrame(byte[] data, Size frameSize);
}
