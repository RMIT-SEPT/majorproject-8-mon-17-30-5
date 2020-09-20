import React from 'react';
import { mount,configure } from 'enzyme';
import { MemoryRouter } from 'react-router';
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import App from '../../App';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

configure({ adapter: new Adapter() });

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/admin/login' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(<NavigationBarAdminPage/>)).toHaveLength(0);
  });

  it("render admin nav bar correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<NavigationBarAdminPage/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children.type).toBe('ul');
});