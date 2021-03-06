package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractBaseFigureEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.MediatorFlow25ItemSemanticEditPolicy;

/**
 * @generated
 */
public class MediatorFlow25EditPart extends ShapeNodeEditPart {

    // Inbound Endpoint Sequence
    /**
     * @generated
     */
    public static final int VISUAL_ID = 3774;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    protected IFigure primaryShape;

    /**
     * @generated
     */
    public MediatorFlow25EditPart(View view) {
        super(view);
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MediatorFlow25ItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated
     */
    protected IFigure createNodeShape() {
        return primaryShape = new MediatorFlowFigure();
    }

    /**
     * @generated
     */
    public MediatorFlowFigure getPrimaryShape() {
        return (MediatorFlowFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * This method is used to rearrange input and output connectors according to the current dimensions of the
     * container.
     * 
     * @param childEditPart
     */
    public void refreshConnector(EditPart childEditPart) {
        if (childEditPart instanceof InboundEndpointEditPart) {
            InboundEndpointEditPart inboundEndpointEditPart = (InboundEndpointEditPart) childEditPart;
            BorderItemLocator outputLocator = new FixedBorderItemLocator(this.getFigure(),
                    inboundEndpointEditPart.sequenceOutputConnectorFigure, PositionConstants.WEST, 0.5);
            inboundEndpointEditPart.getBorderedFigure().getBorderItemContainer()
                    .add(inboundEndpointEditPart.sequenceOutputConnectorFigure, outputLocator);

            BorderItemLocator inputLocator = new FixedBorderItemLocator(this.getFigure(),
                    inboundEndpointEditPart.sequenceInputConnectorFigure, PositionConstants.EAST, 0.5);
            inboundEndpointEditPart.getBorderedFigure().getBorderItemContainer()
                    .add(inboundEndpointEditPart.sequenceInputConnectorFigure, inputLocator);

        } else {
            // Should handle properly.
            // throw new ClassCastException();
        }
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof ResizableCompartmentEditPart) {
            // Compartment should be added to the primary shape.
            return getPrimaryShape();
        } else {
            return super.getContentPaneFor(editPart);
        }
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated NOT
     */
    public class MediatorFlowFigure extends EsbMediatorFlowFigure {

        /**
         * @generated NOT
         */

        public MediatorFlowFigure() {

            this.setBackgroundColor(THIS_BACK);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(30000), getMapMode().DPtoLP(30000)));
        }
        /*
         * public MediatorFlowFigure() {
         * GridLayout layoutThis = new GridLayout();
         * layoutThis.numColumns = 1;
         * layoutThis.horizontalSpacing = 5;
         * layoutThis.verticalSpacing = 5;
         * layoutThis.marginHeight = 5;
         * layoutThis.marginWidth = 5;
         * layoutThis.makeColumnsEqualWidth = true;
         * this.setLayoutManager(layoutThis);
         * 
         * this.setCornerDimensions(new Dimension(1, 1));
         * this.setOutline(false);
         * this.setBackgroundColor(THIS_BACK);
         * this.setForegroundColor(new Color(null, 0, 0, 0));
         * this.setPreferredSize(new Dimension(getMapMode().DPtoLP(30000),
         * getMapMode().DPtoLP(30000)));
         * }
         * 
         * public void add(IFigure figure, Object constraint, int index) {
         * if (figure instanceof BorderedNodeFigure) {
         * GridData layoutData = new GridData();
         * layoutData.grabExcessHorizontalSpace = true;
         * layoutData.grabExcessVerticalSpace = true;
         * layoutData.horizontalAlignment = GridData.FILL;
         * layoutData.verticalAlignment = GridData.FILL;
         * super.add(figure, layoutData, index);
         * } else {
         * super.add(figure, constraint, index);;
         * }
         * }
         */

    }

    public boolean isSelectable() {
        return false;
    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
