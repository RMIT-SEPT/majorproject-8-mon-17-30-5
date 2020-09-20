import React from 'react';
import { mount,configure } from 'enzyme';
import { MemoryRouter } from 'react-router';
import NavigationBarWorkerPage from '../Layout/NavigationBarWorkerPage';
import App from '../../App';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

configure({ adapter: new Adapter() });

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/Worker/login=' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(<NavigationBarWorkerPage/>)).toHaveLength(0);
  });

  it("render admin nav bar correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<NavigationBarWorkerPage/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children.type).toBe('ul');
});