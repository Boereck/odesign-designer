package odesign.design;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.common.ui.tools.api.editor.IEObjectNavigable;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenOdesignEditorAction extends AbstractExternalJavaAction {

	private static final String SIRIUS_EDITOR_ID = "org.eclipse.sirius.editor.editorPlugin.SiriusEditorID";

	public static void openEditorFor(EObject object) {

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> elements) {
		return elements != null && elements.size() == 1;
	}

	@Override
	public void execute(Collection<? extends EObject> elements, Map<String, Object> arguments) {
		// find semantic Odesign element
		EObject object = elements.iterator().next();
		if (!(object instanceof DRepresentationElement)) {
			return;
		}
		DRepresentationElement representation = (DRepresentationElement) object;
		EList<EObject> semanticElements = representation.getSemanticElements();
		if (semanticElements.size() == 0) {
			return;
		}
		final EObject semanticElement = semanticElements.get(0);
		
		// Semantic element found, try to open Sirius editor
		URI uri = EcoreUtil.getURI(semanticElement);
		IWorkbench wb = PlatformUI.getWorkbench();
		if(wb == null) {
			return;
		}
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		if(win == null) {
			return;
		}
		IWorkbenchPage page = win.getActivePage();
		if(page == null) {
			return;
		}
		// Open Sirius editor with the odesign file
		URIEditorInput uei = new URIEditorInput(uri.trimFragment());
		try {
			final IEditorPart part = page.openEditor(uei, SIRIUS_EDITOR_ID, true);
			// try to set the selection in the opened editor to the selected element
			if(part instanceof IEObjectNavigable) {
				((IEObjectNavigable) part).navigateToEObject(uri);
			}
		} catch (PartInitException e) {
			// if this does not work, do nothing
		}
	}

}
