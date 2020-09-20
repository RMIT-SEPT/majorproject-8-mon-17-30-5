import React from 'react';
import { mount,configure } from 'enzyme';
import { MemoryRouter } from 'react-router';
import NavigationBarCustomerPage from '../Layout/NavigationBarCustomerPage';
import App from '../../App';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

configure({ adapter: new Adapter() });

test('valid path for customer login page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/loginForm' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(<NavigationBarCustomerPage/>)).toHaveLength(0);
  });

  it("render customer nav bar correctly", () => {
    const renderer = new ShallowRenderer();
    renderer.render(<NavigationBarCustomerPage/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children.type).toBe('ul');
});