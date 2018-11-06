import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class MySliderUI2 extends BasicSliderUI
{

	public MySliderUI2(JSlider b) {
		super(b);
	}
	@Override
	public void paintThumb(Graphics g) {
        //����ָʾ��
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.gray);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(thumbRect.x, thumbRect.y, thumbRect.width,
                thumbRect.height);//�޸�ΪԲ��
        //Ҳ������ͼ(��������¼�ת��image�������ֲ�ͬ״̬)
        //g2d.drawImage(image, thumbRect.x, thumbRect.y, thumbRect.width,thumbRect.height,null);

	}
	public void paintTrack(Graphics g) {
        //���ƿ̶ȵĹ켣
		int cy,cw;
		Rectangle trackBounds = trackRect;
		if (slider.getOrientation() == JSlider.HORIZONTAL) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(new Color(211, 211, 211));//��������Ϊ��ɫ
			cy = (trackBounds.height/2) - 2;
			cw = trackBounds.width;
			
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.translate(trackBounds.x, trackBounds.y + cy);
			g2.fillRect(0, -cy + 5, cw, cy);
			
			int trackLeft = 0;
			int trackRight = 0;
			trackRight = trackRect.width - 1;

			int middleOfThumb = 0;
			int fillLeft = 0;
			int fillRight = 0;
			//��������
			middleOfThumb = thumbRect.x + (thumbRect.width / 2);
			middleOfThumb -= trackRect.x;
			
			if (!drawInverted()) {
				fillLeft = !slider.isEnabled() ? trackLeft : trackLeft + 1;
				fillRight = middleOfThumb;
				} else {
				fillLeft = middleOfThumb;
				fillRight = !slider.isEnabled() ? trackRight - 1
				: trackRight - 2;
				}
			//�趨����,������Ӻ�ɫ��Ϊ��ɫ,��û�н���,���黮���ĵط��Զ���ɺ�ɫ
			g2.setPaint(new GradientPaint(0, 0, Color.red, cw, 0,
					Color.red, true));
			g2.fillRect(0, -cy + 5, fillRight - fillLeft, cy);
					
			g2.setPaint(slider.getBackground());
			g2.fillRect(10, 10, cw, 5);

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_OFF);
			g2.translate(-trackBounds.x, -(trackBounds.y + cy));   					
		}
		else {
			super.paintTrack(g);
			}
	}
}
