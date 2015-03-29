package com.saintsrobotics.treecycle.commands;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Range;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;

public class CameraCommand extends CommandBase {
    
    int session;
    Image raw;
    
    NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);    
    
    @Override
    protected void initialize() {
        raw = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        NIVision.IMAQdxStartAcquisition(session);
    }

    @Override
    protected void execute() {
        NIVision.IMAQdxGrab(session, raw, 1);
        NIVision.imaqColorThreshold(raw, raw, 1, NIVision.ColorMode.HSI,
                new Range(0, 255), new Range(0, 255), new Range(200, 255));
        NIVision.imaqDrawShapeOnImage(raw, raw, rect,
                DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        
        CameraServer.getInstance().setImage(raw);
        System.out.println("lel");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        NIVision.IMAQdxStopAcquisition(session);
    }
}
